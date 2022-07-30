package com.faithl.milim;

import com.faithl.milim.api.impl.AttributeException;
import com.faithl.milim.api.impl.attributeplus.AttributePlus;
import com.faithl.milim.api.impl.attributeplus.AttributePlusLegacy;
import com.faithl.milim.api.impl.attributesystem.AttrSystem;
import com.faithl.milim.api.impl.originattribute.OriginAttribute;
import com.faithl.milim.api.impl.sxattribute.SxAttribute;
import com.faithl.milim.util.Version;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author Leosouthey
 * @date 2021/12/31-18:37
 **/
public abstract class AttributeManager {

    /**
     * 获取实体属性数据
     *
     * @param livingEntity 实体
     * @return 实体属性数据
     */
    public abstract Object getData(LivingEntity livingEntity);

    /**
     * 设置实体属性
     *
     * @param source       来源
     * @param livingEntity 实体
     * @param attribute    属性
     */
    public abstract void setAttribute(String source, LivingEntity livingEntity, List<String> attribute);

    /**
     * 设置实体属性
     *
     * @param source       来源
     * @param livingEntity 实体
     * @param attribute    属性
     */
    public abstract void setAttribute(String source, LivingEntity livingEntity, HashMap<String, Number[]> attribute);

    /**
     * 设置实体属性
     *
     * @param source       来源
     * @param livingEntity 实体
     * @param attribute    属性
     */
    public abstract void setAttribute(String source, LivingEntity livingEntity, String attribute);

    /**
     * 设置实体属性
     *
     * @param source       来源
     * @param livingEntity 实体
     * @param itemStack    物品
     */
    public abstract void setAttribute(String source, LivingEntity livingEntity, ItemStack itemStack);

    /**
     * 删除实体属性
     *
     * @param source       来源
     * @param livingEntity 实体
     */
    public abstract void deleteAttribute(String source, LivingEntity livingEntity);

    public static AttributeManager getInstance(String plugin) {
        try {
            switch (plugin) {
                case "AP":
                case "AttributePlus":
                    Version split = new Version("3.0.0");
                    Version now = new Version(
                            Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("AttributePlus")).getDescription().getVersion());
                    if (now.isAfter(split)) {
                        return new AttributePlus();
                    } else {
                        return new AttributePlusLegacy();
                    }
                case "OA":
                case "OriginAttribute":
                    return new OriginAttribute();
                case "SX":
                case "SX-Attribute":
                    return new SxAttribute();
                case "AS":
                case "AttributeSystem":
                    return new AttrSystem();
                default:
                    return new AttributeException(new Throwable("Wrong attribute plugin"));
            }
        } catch (Throwable e) {
            return new AttributeException(e);
        }
    }

}
