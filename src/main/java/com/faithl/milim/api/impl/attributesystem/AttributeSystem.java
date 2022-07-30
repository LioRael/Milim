package com.faithl.milim.api.impl.attributesystem;

import com.faithl.milim.AttributeManager;
import com.skillw.attsystem.api.AttrAPI;
import com.skillw.attsystem.api.attribute.compound.AttributeDataCompound;
import com.skillw.attsystem.api.read.ReadGroup;
import com.skillw.attsystem.api.status.NumberStatus;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AttributeSystem extends AttributeManager {
    @Override
    public AttributeDataCompound getData(LivingEntity livingEntity) {
        return AttrAPI.getAttrData(livingEntity);
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, List<String> attribute) {
        AttrAPI.removeAttribute(livingEntity,source);
        AttrAPI.addAttribute(livingEntity,source,attribute,false);
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, HashMap<String, Number[]> attribute) {
        AttrAPI.removeAttribute(livingEntity,source);
        getData(livingEntity).forEach((key, attrData) -> attrData.forEach((attr, value) -> {
            if (attribute.containsKey(attr.getKey()) && attr.getReadPattern() instanceof ReadGroup) {
                Number[] num = attribute.get(attr.getKey());
                if (num == null){
                    return;
                }
                NumberStatus numberStatus = (NumberStatus) value;
                numberStatus.set("valueMin", num[0].doubleValue());
                numberStatus.set("valueMax", num[1].doubleValue());
            }
        }));
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, String attribute) {
        List<String> list = new ArrayList<>();
        AttrAPI.removeAttribute(livingEntity,source);
        AttrAPI.addAttribute(livingEntity,source,list,false);
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, ItemStack itemStack) {
        AttrAPI.removeAttribute(livingEntity,source);
        AttrAPI.readItem(itemStack,livingEntity,null);
    }

    @Override
    public void deleteAttribute(String source, LivingEntity livingEntity) {
        AttrAPI.removeAttribute(livingEntity,source);
    }
}
