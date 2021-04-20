package me.RoboBoy99.WildCore.Reboot.Runnables;


import me.RoboBoy99.WildCore.WildCore;

public class Runnables {
	
	@SuppressWarnings("deprecation")
	public static void CheckSeconds(){
        WildCore.getInstance().getServer().getScheduler().scheduleAsyncRepeatingTask(WildCore.getInstance(), new Runnable() {
            public void run() {
            	if(WildCore.getInstance().Seconds) {
            		WildCore.getInstance().getServer().dispatchCommand(WildCore.getInstance().getServer().getConsoleSender(), "restart");
            	}
            }
        }, 0, 600L);
    }
	
	@SuppressWarnings("deprecation")
	public static void CheckMinute(){
        WildCore.getInstance().getServer().getScheduler().scheduleAsyncRepeatingTask(WildCore.getInstance(), new Runnable() {
            public void run() {
            	if(WildCore.getInstance().Minute) {
            		WildCore.getInstance().getServer().dispatchCommand(WildCore.getInstance().getServer().getConsoleSender(), "restart");
            	}
            }
        }, 0, 1200);
    }
	
	@SuppressWarnings("deprecation")
	public static void CheckFiveMinutes(){
        WildCore.getInstance().getServer().getScheduler().scheduleAsyncRepeatingTask(WildCore.getInstance(), new Runnable() {
            public void run() {
				if(WildCore.getInstance().FiveMinutes) {
            		WildCore.getInstance().getServer().dispatchCommand(WildCore.getInstance().getServer().getConsoleSender(), "restart");
				}
            }
        }, 0, 6000);
    }
}
