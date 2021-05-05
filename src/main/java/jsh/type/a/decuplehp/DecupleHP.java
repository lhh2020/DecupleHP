package jsh.type.a.decuplehp;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class DecupleHP extends JavaPlugin implements Listener
{
	@Override
	public void onEnable()
    {
	    getServer().getPluginManager().registerEvents(this, this);
	}

	@Override
	public void onDisable()
    {

	}

	@EventHandler
	public void creatureSpawnEvent(CreatureSpawnEvent e)
	{
		getServer().broadcastMessage((e.getEntity().getHealth()*10) + "  " + e.getEntity().getName());

		e.getEntity().setMaxHealth(e.getEntity().getHealth()*10);
		e.getEntity().setHealth(e.getEntity().getHealth()*10);
	}
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e)
	{
		e.getDamager().sendMessage(
				String.format("%s%s%s에게 %s%f%s데미지를 주었습니다 [ 남은 채력 %f ]",
				ChatColor.GOLD, e.getEntity().getName(), ChatColor.WHITE, ChatColor.GOLD, e.getDamage(), ChatColor.WHITE, ((LivingEntity)e.getEntity()).getHealth())
		);
	}
}
