package fr.gabidut76.mods.phonemod.tabs;

import fr.gabidut76.mods.phonemod.PhoneMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MainTab extends CreativeTabs
{
    private String label;
    public MainTab(String label)
    {
        super(label);
        this.label = label;
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(PhoneMod.phoneblock);
    }


}
