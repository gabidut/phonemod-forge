package fr.zoneecho.mod.objects.blocks;

import fr.dynamx.common.blocks.DynamXBlock;
import fr.zoneecho.mod.PhoneMod;
import fr.zoneecho.mod.objects.tiles.TilePhone;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockDynxPhone extends DynamXBlock {
    int min = 1111;
    int max = 9999;


    public BlockDynxPhone(Material material, String modid, String blockName, String model) {
        super(material, modid, blockName, model);
        setCreativeTab(PhoneMod.PhoneModTab);
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        if(!worldIn.isRemote) {
            int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            assert tileEntity != null;
            tileEntity.getTileData().setInteger("code", random_int);
            System.out.println(random_int);
        }
    }


    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {


        return new TilePhone();
    }

}
