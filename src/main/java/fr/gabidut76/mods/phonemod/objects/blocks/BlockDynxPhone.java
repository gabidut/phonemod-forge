package fr.gabidut76.mods.phonemod.objects.blocks;

import fr.dynamx.common.blocks.DynamXBlock;
import fr.gabidut76.mods.phonemod.PhoneMod;
import fr.gabidut76.mods.phonemod.objects.tiles.TilePhone;
import fr.gabidut76.mods.phonemod.util.network.PacketCallMenu;
import fr.gabidut76.mods.phonemod.util.network.PacketMainMenu;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Objects;

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
            // save as hasmap the world and the pos
            PhoneMod.dbPhones.setBlockPos(String.valueOf(random_int), pos);


            TileEntity tileEntity = worldIn.getTileEntity(pos);
            assert tileEntity != null;
            tileEntity.getTileData().setInteger("code", random_int);
            System.out.println(random_int);
        }
    }

    @Override
    public void onBlockExploded(World world, BlockPos pos, Explosion explosion) {
        if(world.isRemote) {
            PhoneMod.dbPhones.remove(String.valueOf(Objects.requireNonNull(world.getTileEntity(pos)).getTileData().getInteger("code")));
        }
    }

    @Override
    public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) {
        if(!worldIn.isRemote) {
            PhoneMod.dbPhones.remove(String.valueOf(Objects.requireNonNull(worldIn.getTileEntity(pos)).getTileData().getInteger("code")));
        }
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        if(!worldIn.isRemote) {
            PhoneMod.dbPhones.remove(String.valueOf(Objects.requireNonNull(worldIn.getTileEntity(pos)).getTileData().getInteger("code")));
        }
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote) {
            if(PhoneMod.dbPhonesRing.getInteger(String.valueOf(Objects.requireNonNull(worldIn.getTileEntity(pos)).getTileData().getInteger("code"))) == 1) {
                PhoneMod.network.sendTo(new PacketCallMenu(Objects.requireNonNull(worldIn.getTileEntity(pos)).getTileData().getInteger("code")), (EntityPlayerMP) playerIn);
                return true;
            } else {
                PhoneMod.network.sendTo(new PacketMainMenu(Objects.requireNonNull(worldIn.getTileEntity(pos)).getTileData().getInteger("code")), (EntityPlayerMP) playerIn);
                return true;
            }

        }
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {


        return new TilePhone();
    }

}
