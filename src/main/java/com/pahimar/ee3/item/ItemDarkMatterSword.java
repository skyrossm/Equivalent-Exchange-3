package com.pahimar.ee3.item;

import com.pahimar.ee3.creativetab.CreativeTab;
import com.pahimar.ee3.reference.Material;
import com.pahimar.ee3.reference.Names;
import com.pahimar.ee3.util.IChargeable;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemDarkMatterSword extends ItemSword {
    public ItemDarkMatterSword() {
        super(Material.Tools.DARK_MATTER);
        this.setCreativeTab(CreativeTab.EE3_TAB);
        this.setNoRepair();
        this.maxStackSize = 1;
        this.setUnlocalizedName(Names.Weapons.DARK_MATTER_SWORD);
    }

    @Override
    public boolean getShareTag() {
        return true;
    }

    @Override
    public boolean showDurabilityBar(ItemStack itemStack) {
        if (itemStack.getItem() instanceof IChargeable) {
            return ((IChargeable) itemStack.getItem()).getChargeLevel(itemStack) > 0;
        }

        return false;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack itemStack) {
        if (itemStack.getItem() instanceof IChargeable) {
            return (double) (((IChargeable) itemStack.getItem()).getMaxChargeLevel() - ((IChargeable) itemStack.getItem()).getChargeLevel(itemStack)) / (double) ((IChargeable) itemStack.getItem()).getMaxChargeLevel();
        }

        return 1d;
    }
}