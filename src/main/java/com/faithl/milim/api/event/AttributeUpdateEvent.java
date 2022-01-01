package com.faithl.milim.api.event;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * @author Leosouthey
 * @ 2021/12/31-19:05
 **/
public class AttributeUpdateEvent extends Event implements Cancellable {

    public static HandlerList handlers = new HandlerList();

    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * 属性来源
     */
    public String source;

    /**
     * 生物
     */
    public LivingEntity livingEntity;

    private boolean cancelled = false;

    /**
     * 属性更新事件
     *
     * @param source       来源
     * @param livingEntity 生物
     */
    public AttributeUpdateEvent(String source, LivingEntity livingEntity) {
        this.source = source;
        this.livingEntity = livingEntity;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return getHandlerList();
    }

    @Override
    public void setCancelled(boolean value) {
        cancelled = value;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

}
