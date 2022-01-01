package com.faithl.milim.api.impl.attributeplus;

import com.faithl.milim.AttributeManager;
import com.faithl.milim.util.Collection;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.serverct.ersha.api.AttributeAPI;
import org.serverct.ersha.attribute.data.AttributeData;

import java.util.HashMap;
import java.util.List;

/**
 * @author Leosouthey
 * @date 2021/12/31-20:12
 **/
public class AttributePlus extends AttributeManager {

    @Override
    public AttributeData getData(LivingEntity livingEntity) {
        return AttributeAPI.getAttrData(livingEntity);
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, List<String> attribute) {
        AttributeData data = getData(livingEntity);
        AttributeAPI.takeSourceAttribute(data, source);
        AttributeAPI.addSourceAttribute(data, source, attribute);
        data.updateAttribute(true);
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, HashMap<String, Number[]> attribute) {
        AttributeData data = getData(livingEntity);
        AttributeAPI.takeSourceAttribute(data, source);
        AttributeAPI.addSourceAttribute(data, source, attribute);
        data.updateAttribute(true);
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, String attribute) {
        AttributeData data = getData(livingEntity);
        AttributeAPI.takeSourceAttribute(data, source);
        AttributeAPI.addSourceAttribute(data, source, Collection.asList(attribute));
        data.updateAttribute(true);
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, ItemStack itemStack) {
        AttributeData data = getData(livingEntity);
        AttributeAPI.takeSourceAttribute(data, source);
        AttributeAPI.addSourceAttribute(data, source, itemStack);
        data.updateAttribute(true);
    }

    @Override
    public void deleteAttribute(String source, LivingEntity livingEntity) {
        AttributeData data = getData(livingEntity);
        AttributeAPI.takeSourceAttribute(data, source);
        data.updateAttribute(true);
    }

}
