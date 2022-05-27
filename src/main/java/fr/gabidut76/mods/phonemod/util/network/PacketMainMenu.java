package fr.gabidut76.mods.phonemod.util.network;

import fr.aym.acsguis.api.ACsGuiApi;
import fr.gabidut76.mods.phonemod.util.gui.GuiMain;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PacketMainMenu implements IMessage {
    private int phoneNumber;
    public PacketMainMenu() {
    }

    public PacketMainMenu(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    @Override
    public void fromBytes(ByteBuf buf) {
        phoneNumber = ByteBufUtils.readVarInt(buf,5);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeVarInt(buf, phoneNumber, 5);
    }

    public static class Handler implements IMessageHandler<PacketMainMenu, IMessage> {
        @Override
        @SideOnly(Side.CLIENT)
        public IMessage onMessage(PacketMainMenu message, MessageContext ctx) {
            ACsGuiApi.asyncLoadThenShowGui("cardwriter", () -> new GuiMain(message.phoneNumber));
            return null;
        }
    }
}
