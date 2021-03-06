package LSDtools.commands;

import LSDtools.LSDtools;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.File;

public class info implements CommandExecutor {
    //单独的命令类需要继承CommandExecutor来执行命令，若要实现TAB补全则继承TabExecutor

    @Override
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        //插件的信息
        if (args.length == 0 || args[0].equals("1")) {
            sender.sendMessage("§r>> §e§lLSDtools §a§lv " + LSDtools.pversion + " §r<< §7by LSDog.");
            sender.sendMessage("§5/LSDtools: §r插件信息");
            sender.sendMessage("§5/LSDtools reload: §r重载插件");
            sender.sendMessage("§5/LSDtools <页数>: §r察看第n页的提示");
            sender.sendMessage("========== 1/2 ==========");
        } else if (args[0].equals("2")) {
            sender.sendMessage("§5/lore: §r修改物品信息");
            sender.sendMessage("§5/crash: §r错误踢出/卡顿/崩溃某玩家");
            sender.sendMessage("§5/signedit: §r修改告示牌");
            sender.sendMessage("§5/gettools: §r获取一些小工具");
            sender.sendMessage("§5/checkplayer: §r检查某玩家信息");
            sender.sendMessage("§5/tpv: §r隐身传送到某玩家");
            sender.sendMessage("========== 2/2 ==========");
        } else if (args[0].equalsIgnoreCase("reload")) { //重载插件
            sender.sendMessage(LSDtools.pname + "重载中...");
            LSDtools.MainTool.reloadConfig(); //有的话就重载配置好了
            sender.sendMessage(LSDtools.pname + "重载完毕！");
            return true;
        } else {
            return true;
        }
        return true;
    }
}