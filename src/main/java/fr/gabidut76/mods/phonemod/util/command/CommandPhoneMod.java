package fr.gabidut76.mods.phonemod.util.command;

import fr.gabidut76.mods.phonemod.PhoneMod;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.init.SoundEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

import java.util.Objects;

public class CommandPhoneMod extends CommandBase {


    @Override
    public String getName() {
        return "phonemod";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "phonemod";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if(Objects.equals(args[0], "ring")) {
            sender.sendMessage(new TextComponentString("Ringing..."));
            BlockPos pos = PhoneMod.dbPhones.get(args[1]).asBlockPos();

            sender.getEntityWorld().playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1, 1, true);

            // TODO: try and catch if null pointer exception number isn't in the database so no attributed



        }
    }
}