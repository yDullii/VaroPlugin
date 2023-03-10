package de.dullimc;

import de.cuuky.cfw.utils.JavaUtils;
import de.cuuky.cfw.version.ServerSoftware;
import de.cuuky.cfw.version.VersionUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    /*
     * Plugin by yDulli, TommeX, Limess07 @ 2023
     */

    private static final String CONSOLE_PREFIX = "[Varo] ";
    private static final int RESOURCE_ID = -1; // TODO Update when uploaded to SpigotMC (Dulli)
    public static final String DISCORD_INVITE = "https://discord.dullimc.de/"; // TODO Create website link to DC

    private static Main instance;

    private boolean failed;

    @Override
    public void onLoad() {
        this.failed = false;
        this.instance = this;

        super.onLoad();
    }

    @Override
    public void onEnable() {
        long timestamp = System.currentTimeMillis();

        System.out.println("############################################################################");
        System.out.println("#                                                                          #");
        System.out.println("#                           VaroPlugin by yDulli                           #");
        System.out.println("#                                                                          #");
        System.out.println("############################################################################");

        System.out.println(CONSOLE_PREFIX);
        System.out.println(CONSOLE_PREFIX + "Enabling " + getPluginName() + "...");

        System.out.println(CONSOLE_PREFIX + "Your server: ");
        System.out.println(CONSOLE_PREFIX + "	Running on " + VersionUtils.getServerSoftware().getName() + " ("
                + Bukkit.getVersion() + ")");
        System.out.println(CONSOLE_PREFIX + "	Software-Name (Base): " + Bukkit.getName() + " (1."
                + VersionUtils.getVersion().getIdentifier() + ")");
        System.out.println(
                CONSOLE_PREFIX + "	Other plugins enabled: " + (Bukkit.getPluginManager().getPlugins().length - 1));

        if (VersionUtils.getServerSoftware() != ServerSoftware.UNKNOWN)
            System.out
                    .println(CONSOLE_PREFIX + "	Forge-Support: " + VersionUtils.getServerSoftware().hasModSupport());

        if (VersionUtils.getServerSoftware() == ServerSoftware.BUKKIT) {
            System.out.println(CONSOLE_PREFIX
                    + "	It seems like you're using Bukkit. Bukkit has a worse performance and is lacking some features.");
            System.out.println(
                    CONSOLE_PREFIX + "	Please use Spigot or Paper instead (https://getbukkit.org/download/spigot).");
        }
        System.out.println(CONSOLE_PREFIX);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }

    public static String getPluginName() {
        return instance.getDescription().getName() + " v" + instance.getDescription().getVersion() + " by "
                + instance.getDescription().getAuthors().get(0) + " - Contributors: " + getContributors();
    }

    public static String getContributors() {
        return JavaUtils.getArgsToString(
                JavaUtils.removeString(JavaUtils.arrayToCollection(instance.getDescription().getAuthors()), 0), ", ");
    }

    public static Main getInstance() {
        return instance;
    }
}
