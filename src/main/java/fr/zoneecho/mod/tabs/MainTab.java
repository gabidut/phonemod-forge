package fr.zoneecho.mod.tabs;

import fr.zoneecho.mod.PhoneMod;
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
    public ItemStack getTabIconItem()
    {
            return new ItemStack(PhoneMod.phoneblock);
        }

}
