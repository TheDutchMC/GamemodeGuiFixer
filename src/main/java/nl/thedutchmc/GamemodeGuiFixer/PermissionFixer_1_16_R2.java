package nl.thedutchmc.GamemodeGuiFixer;

import net.minecraft.server.v1_16_R2.Entity;
import net.minecraft.server.v1_16_R2.EntityPlayer;
import net.minecraft.server.v1_16_R2.Packet;
import net.minecraft.server.v1_16_R2.PacketPlayOutEntityStatus;
import net.minecraft.server.v1_16_R2.PlayerConnection;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PermissionFixer_1_16_R2 implements PermissionFixer {
    public void patch(Player p) {
        EntityPlayer ep = ((CraftPlayer)p).getHandle();
        PlayerConnection pc = ep.playerConnection;
        PacketPlayOutEntityStatus packet = new PacketPlayOutEntityStatus((Entity)ep, (byte)28);

        pc.sendPacket((Packet)packet);
    }
}
