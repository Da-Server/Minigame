package minigame.minigame.bukkit.gui.components;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * An Enum That holds ItemStacks
 */
public enum MenuGlass {

    /**
     * White Stained glass
     */
    WHITE {
        /**
         * builds the glass
         * @return returns the ItemStack
         */
        public ItemStack build() {
            ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
            ItemMeta m = i.getItemMeta();
            m.setDisplayName(" ");
            i.setItemMeta(m);
            return i;
        }
    },
    /**
     * Orange Stained glass
     */
    ORANGE {
        /**
         * builds the glass
         * @return returns the ItemStack
         */
        public ItemStack build() {
            ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
            ItemMeta m = i.getItemMeta();
            m.setDisplayName(" ");
            i.setItemMeta(m);
            return i;
        }
    },
    /**
     * Magenta Stained glass
     */
    MAGENTA {
        /**
         * builds the glass
         * @return returns the ItemStack
         */
        public ItemStack build() {
            ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 2);
            ItemMeta m = i.getItemMeta();
            m.setDisplayName(" ");
            i.setItemMeta(m);
            return i;
        }
    },
    /**
     * White Stained glass
     */
    LIGHT_BLUE {
        /**
         * builds the glass
         * @return returns the ItemStack
         */
        public ItemStack build() {
            ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3);
            ItemMeta m = i.getItemMeta();
            m.setDisplayName(" ");
            i.setItemMeta(m);
            return i;
        }
    },


    /**
     * Black Stained glass
     */
    BLACK {
        /**
         * builds the glass
         * @return returns the ItemStack
         */
        public ItemStack build() {
            ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta m = i.getItemMeta();
            m.setDisplayName(" ");
            i.setItemMeta(m);
            return i;
        }
    }

}
