package LSDtools.commands;

import LSDtools.LSDtools;
import LSDtools.world.tools.tpTool;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gettools implements CommandExecutor {
    private final tpTool tpTool = new tpTool();

    @Override
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (!(sender instanceof Player)) { //确保执行者是玩家
            sender.sendMessage(LSDtools.pname + "只有玩家能做这个!");
            return true;
        }
        if (args.length < 1) { //没有参数则介绍小工具
            sender.sendMessage(LSDtools.pname + "用法: /gettools <序号>");
            sender.sendMessage(LSDtools.pname + "1. §r传送棒");
            return true;
        }
        if (args.length > 2) { //参数过多提示
            sender.sendMessage(LSDtools.pname + "参数过多 - /gettools <序号> [玩家]");
            return true;
        }
        //获取tool
        if (args[0].equalsIgnoreCase("1")) {
            if (args.length == 2) { //若指定玩家
                if (sender.getServer().getPlayer(args[1]) != null) {
                    Player p1 = sender.getServer().getPlayer(args[1]);
                    p1.getInventory().addItem(tpTool.getTool());
                    sender.sendMessage(LSDtools.pname + p1.getName() + "§r§l ➡ " + tpTool.getTool().getItemMeta().getDisplayName());
                    p1.sendMessage(LSDtools.pname + "收到一个" + tpTool.getTool().getItemMeta().getDisplayName());
                    return true;
                } else {
                    sender.sendMessage(LSDtools.pname + "§c没有找到该玩家!");
                    return true;
                }
            } else { //若未指定玩家，则发给自己
                ((Player) sender).getPlayer().getInventory().addItem(tpTool.getTool());
                sender.sendMessage(LSDtools.pname + "收到一个" + tpTool.getTool().getItemMeta().getDisplayName());
                return true;
            }
        } else { //未找到此工具
            sender.sendMessage(LSDtools.pname + "§c没有找到此工具!");
            return true;
        }
    }
}