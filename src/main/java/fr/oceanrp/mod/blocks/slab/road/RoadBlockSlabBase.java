package fr.oceanrp.mod.blocks.slab.road;

import fr.oceanrp.mod.Main;
import fr.oceanrp.mod.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public abstract class RoadBlockSlabBase extends BlockSlab {
    Block half;
    public static final PropertyEnum<Variant> VARIANT = PropertyEnum.<Variant>create("variant", Variant.class);

    public RoadBlockSlabBase(String name, Material material, BlockSlab half)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.ROUTE_TABS);
        this.useNeighborBrightness = !this.isDouble();

        IBlockState state = this.blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);
        if(!this.isDouble()) state = state.withProperty(HALF, EnumBlockHalf.BOTTOM);
        this.half = half;
        BlockInit.BLOCKS.add(this);
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(half);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState state = this.blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);
        if(!this.isDouble()) state = state.withProperty(HALF, ((meta&8) != 0) ? EnumBlockHalf.TOP : EnumBlockHalf.BOTTOM);
        return state;
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int meta = 0;
        if(!this.isDouble() && state.getValue(HALF) == EnumBlockHalf.BOTTOM) meta |= 8;
        return meta;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        if(!this.isDouble()) return new BlockStateContainer(this, VARIANT, HALF);
        else return new BlockStateContainer(this, VARIANT);
    }

    @Override
    public String getUnlocalizedName(int meta)
    {
        return super.getUnlocalizedName();
    }

    @Override
    public IProperty<?> getVariantProperty()
    {
        return VARIANT;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack)
    {
        return Variant.DEFAULT;
    }

    public static enum Variant implements IStringSerializable
    {
        DEFAULT;

        @Override
        public String getName()
        {
            return "default";
        }
    }
}
