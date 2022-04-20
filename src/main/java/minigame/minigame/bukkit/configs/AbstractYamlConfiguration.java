package minigame.minigame.bukkit.configs;

import lombok.SneakyThrows;
import minigame.minigame.bukkit.configs.exceptions.InvalidFileExtensionException;
import org.apache.commons.io.FilenameUtils;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.io.File;
import java.io.IOException;

/**
 * This class is used to ease the process of creating a ConfigurationSerializable configuration
 * @param <DataType> The data class. This is used to be written to the file/read from it
 */
public abstract class AbstractYamlConfiguration<DataType extends ConfigurationSerializable> {

    private final File configurationFile;
    private final YamlConfiguration configurationInstance;
    private final String parentKey;


    protected AbstractYamlConfiguration(final File configurationFile) throws InvalidFileExtensionException {
        this.configurationFile = configurationFile;
        parentKey = configurationFile.getName();

        // checks if file is extending yaml
        if (!isExtendingYamlExtension(configurationFile)) throw new InvalidFileExtensionException();

        // creates file if it does not exist
        try {
            configurationFile.createNewFile();
        } catch (IOException ignored) {}

        // loads configuration from the file
        configurationInstance = YamlConfiguration.loadConfiguration(configurationFile);

        // checks if the file is empty or its data is null, then sets it to default
        if (configurationFile.length() == 0 || configurationInstance.get(parentKey) == null) {
            setData(getDefaultData());
        }
    }

    /**
     * retrieves the data from the file
     * @return The data
     */
    public DataType getData() {
        DataType foundData =  (DataType) configurationInstance.get(parentKey);
        return foundData != null ? foundData : getDefaultData();
    }

    /**
     * Writes data and saves it to the file
     * @param data The data
     */
    public void setData(DataType data) {
        configurationInstance.set(parentKey, data);
        save();
    }

    /**
     * This method should be used to retrieve a default value of the datatype, In case the file was empty or not found
     * @return The default data
     */
    protected abstract DataType getDefaultData();

    /**
     * Saves the data to the file
     */
    @SneakyThrows
    public void save() {
        configurationInstance.save(configurationFile);
    }

    /**
     * This method is used to check if a file extends the yaml extension (ends with ".yml" or ".yaml")
     * @param file The file to be checked
     * @return true if it extends yaml, false otherwise
     */
    private boolean isExtendingYamlExtension(File file) {
        String extension = FilenameUtils.getExtension(file.getName());
        return extension.equalsIgnoreCase("yml") || extension.equalsIgnoreCase("yaml");
    }
}
