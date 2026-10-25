package ianm1647.expandeddelight.common.item;

import ianm1647.expandeddelight.common.block.entity.JuicerBlockEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;


public class JuicerItem extends BlockItem {
    private static final int BAR_COLOR = 0x6666FF;

    public JuicerItem(Block block, Properties properties) {
        super(block, properties);
    }

    public boolean isBarVisible(ItemStack stack) {
        return getServingCount(stack) > 0;
    }

    public int getBarWidth(ItemStack stack) {
        return Math.min(1 + 12 * getServingCount(stack) / 64, 13);
    }

    public int getBarColor(ItemStack stack) {
        return BAR_COLOR;
    }


    private static int getServingCount(ItemStack stack) {
        ItemStack drinkStack = JuicerBlockEntity.getDrinkFromItem(stack);
        return drinkStack.getCount();
    }
}
