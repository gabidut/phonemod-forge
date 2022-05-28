package fr.gabidut76.mods.phonemod.threads;

import net.minecraft.util.math.BlockPos;

public class ChangeVar implements Runnable {
    private final BlockPos pos;
    public ChangeVar(BlockPos pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            System.out.println("switching true" + pos);
            Thread.sleep(30000);
            System.out.println("switching false" + pos);
        } catch (InterruptedException iex) {
            iex.printStackTrace();
        }
    }
}
