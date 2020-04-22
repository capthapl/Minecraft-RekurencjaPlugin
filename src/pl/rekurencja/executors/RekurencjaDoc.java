package pl.rekurencja.executors;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RekurencjaDoc implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("rekurencjaDoc")) { // If the player typed /basic then do the following, note: If you only registered this executor for one command, you don't need this
            commandSender.sendMessage(new String[] {
                    ChatColor.BLUE+"Zmiany ktore wprowadza plugin",
                    "",
                    ChatColor.DARK_PURPLE+"Moby:",
                    ChatColor.LIGHT_PURPLE+ "   Ilosc respu mobow zostala bardzo zwiekszona!",

                    "   Dodany Deadth Dance",
                    ChatColor.DARK_AQUA+ "   Loot:",
                    "       Bandaz/Magiczny bandaz",
                    "       Azure bluet/Skora/Ksiazka/Sztabka zlota",
                    "       Butelki XP/Strzaly/Zlote jablko",
                    ChatColor.DARK_PURPLE+"   Zmiany w wypadaniu przedmiotow:",
                    ChatColor.GREEN+"   Na ilosc dziala bonus Looting",
                    ChatColor.DARK_GREEN+"       Zombie/Szkielety/Pajaki/Pajaki jaskiniowe",
                    ChatColor.DARK_GREEN+"       Creepery moga teraz wyrzucic",
                    ChatColor.DARK_GREEN+"       Butelki z xp, bandaz lub silny bandaz",
                    "       Zombie moze wyrzucic skore",
                    "       Szkielet wyrzuca wiecej strzal",
                    "       Wither Szkielet wyrzuca wiecej czaszek",
                    ChatColor.DARK_PURPLE+"Nowe przedmioty:",
                    "   Bandaz - uzupelnia czesc zdrowia",
                    ChatColor.DARK_AQUA+ "     Crafting:",
                    ChatColor.YELLOW+ "     XAX",
                    ChatColor.YELLOW+ "     XBX",
                    ChatColor.YELLOW+ "     XCX",
                    ChatColor.AQUA+ "     A - Redstone B - Poppy C - Papier",
                    "",
                    "   Magiczny bandaz - uzupelnia wieksza czesc zdrowia",
                    ChatColor.DARK_AQUA+ "     Crafting:",
                    ChatColor.YELLOW+ "     XAX",
                    ChatColor.YELLOW+ "     XBX",
                    ChatColor.YELLOW+ "     XCX",
                    ChatColor.AQUA+ "     A - Diament B - Poppy C - Papier",
                    "",
                    "   4 krysztaly kwarcu ",
                    ChatColor.DARK_AQUA+ "     Crafting:",
                    ChatColor.YELLOW+ "     A",
                    ChatColor.AQUA+ "     A - Blok kwarcu",
                    "",
                    "   Diamentowy Luk - Drogi, ale potezny",
                    ChatColor.DARK_AQUA+ "     Crafting:",
                    ChatColor.YELLOW+ "     AAA",
                    ChatColor.YELLOW+ "     ABA",
                    ChatColor.YELLOW+ "     AAA",
                    ChatColor.AQUA+ "     A - Blok diamentu B - Luk",

            });
            return true;
        }
        return false;
    }
}
