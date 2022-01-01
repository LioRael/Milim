package com.faithl.milim.api.impl;

import com.faithl.milim.AttributeManager;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;

/**
 * @author Leosouthey
 * @date 2021/12/31-18:57
 **/
public class AttributeException extends AttributeManager {

    public AttributeException(Throwable cause) {
        cause.printStackTrace();
    }

    @Override
    public Object getData(LivingEntity livingEntity) {
        throw new IllegalAccessError("Attribute plugin hook failed: ${cause.localizedMessage}");
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, List<String> attribute) {
        throw new IllegalAccessError("Attribute plugin hook failed: ${cause.localizedMessage}");
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, HashMap<String, Number[]> attribute) {
        throw new IllegalAccessError("Attribute plugin hook failed: ${cause.localizedMessage}");
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, String attribute) {
        throw new IllegalAccessError("Attribute plugin hook failed: ${cause.localizedMessage}");
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, ItemStack itemStack) {
        throw new IllegalAccessError("Attribute plugin hook failed: ${cause.localizedMessage}");
    }

    @Override
    public void deleteAttribute(String source, LivingEntity livingEntity) {
        throw new IllegalAccessError("Attribute plugin hook failed: ${cause.localizedMessage}");
    }

}
