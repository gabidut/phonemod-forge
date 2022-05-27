package fr.zoneecho.mod.util.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

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
        server.sendMessage(new TextComponentString("Hello world !"));


    }
}