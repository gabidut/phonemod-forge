package fr.gabidut76.mods.phonemod.util;


import fr.gabidut76.mods.phonemod.PhoneMod;
import fr.gabidut76.mods.phonemod.threads.ChangeVar;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;

public class CallManger {

    public static void call(Integer number, Boolean ring, World world) {
        if(ring) {
            BlockPos pos = PhoneMod.dbPhones.get(String.valueOf(number)).asBlockPos();
            world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1, 1, true);
            CallManger.changeVar(pos);
        } else {
            BlockPos pos = PhoneMod.dbPhones.get(String.valueOf(number)).asBlockPos();
        }
    }

    public static BlockPos getPosByNumber(Integer number) {
        return PhoneMod.dbPhones.get(String.valueOf(number)).asBlockPos();
    }

    public static int getNumberByPos(BlockPos pos, World world) {
        return Objects.requireNonNull(world.getTileEntity(pos)).getTileData().getInteger("code");
    }

    private static void changeVar(BlockPos pos) {
        Runnable r = new ChangeVar(pos);
        new Thread(r).start();
    }
}
