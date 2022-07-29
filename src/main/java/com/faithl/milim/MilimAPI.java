package com.faithl.milim;

import com.faithl.milim.api.event.AttributeUpdateEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.List;

/**
 * @author Leosouthey
 * @date 2021/12/31-17:33
 **/
public class MilimAPI {

    public static AttributeManager attributeManager;

    public static void init(String plugin) {
        attributeManager = AttributeManager.getInstance(plugin);
    }

    public static void setAttribute(String source, LivingEntity livingEntity, List<String> attribute) {
        attributeManager.setAttribute(source, livingEntity, attribute);
        AttributeUpdateEvent event = new AttributeUpdateEvent(source, livingEntity);
        if (call(event)) {
            attributeManager.setAttribute(source, livingEntity, attribute);
        }
    }

    public static void setAttribute(String source, LivingEntity livingEntity, HashMap<String, Number[]> attribute) {
        attributeManager.setAttribute(source, livingEntity, attribute);
        AttributeUpdateEvent event = new AttributeUpdateEvent(source, livingEntity);
        if (call(event)) {
            attributeManager.setAttribute(source, livingEntity, attribute);
        }
    }

    public static void setAttribute(String source, LivingEntity livingEntity, String attribute) {
        AttributeUpdateEvent event = new AttributeUpdateEvent(source, livingEntity);
        if (call(event)) {
            attributeManager.setAttribute(source, livingEntity, attribute);
        }
    }

    public static void setAttribute(String source, LivingEntity livingEntity, ItemStack itemStack) {
        AttributeUpdateEvent event = new AttributeUpdateEvent(source, livingEntity);
        if (call(event)) {
            attributeManager.setAttribute(source, livingEntity, itemStack);
        }
    }

    public static void deleteAttribute(String source, LivingEntity livingEntity) {
        AttributeUpdateEvent event = new AttributeUpdateEvent(source, livingEntity);
        if (call(event)) {
            attributeManager.deleteAttribute(source, livingEntity);
        }
    }

    public static boolean call(AttributeUpdateEvent event) {
        new BukkitRunnable(){

            @Override
            public void run() {
                Bukkit.getPluginManager().callEvent(event);
            }

        }.run();
        return !event.isCancelled();
    }

}
