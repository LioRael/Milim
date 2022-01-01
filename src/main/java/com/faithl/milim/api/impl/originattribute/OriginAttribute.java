package com.faithl.milim.api.impl.originattribute;

import ac.github.oa.api.OriginAttributeAPI;
import ac.github.oa.internal.attribute.AttributeData;
import com.faithl.milim.AttributeManager;
import com.faithl.milim.util.Collection;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

import java.util.*;

/**
 * @author Leosouthey
 * @date 2021/12/31-20:23
 **/
public class OriginAttribute extends AttributeManager {

    @Override
    public AttributeData getData(LivingEntity livingEntity) {
        return OriginAttributeAPI.INSTANCE.getAttributeData(livingEntity);
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, List<String> attribute) {
        OriginAttributeAPI.INSTANCE.removeExtra(livingEntity.getUniqueId(), source);
        OriginAttributeAPI.INSTANCE.setExtra(livingEntity.getUniqueId(), source, OriginAttributeAPI.INSTANCE.loadList(attribute));
        OriginAttributeAPI.INSTANCE.callUpdate(livingEntity);
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, HashMap<String, Number[]> attribute) {
        List<String> list = new ArrayList<String>();
        for (String key : attribute.keySet()) {
            list.add(key + ": " + Arrays.toString(attribute.get(key)));
        }
        OriginAttributeAPI.INSTANCE.removeExtra(livingEntity.getUniqueId(), source);
        OriginAttributeAPI.INSTANCE.setExtra(livingEntity.getUniqueId(), source, OriginAttributeAPI.INSTANCE.loadList(list));
        OriginAttributeAPI.INSTANCE.callUpdate(livingEntity);
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, String attribute) {
        OriginAttributeAPI.INSTANCE.removeExtra(livingEntity.getUniqueId(), source);
        OriginAttributeAPI.INSTANCE.setExtra(livingEntity.getUniqueId(), source, OriginAttributeAPI.INSTANCE.loadList(Collection.asList(attribute)));
        OriginAttributeAPI.INSTANCE.callUpdate(livingEntity);
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, ItemStack itemStack) {
        OriginAttributeAPI.INSTANCE.removeExtra(livingEntity.getUniqueId(), source);
        OriginAttributeAPI.INSTANCE.setExtra(livingEntity.getUniqueId(), source, OriginAttributeAPI.INSTANCE.loadList(Objects.requireNonNull(Objects.requireNonNull(itemStack.getItemMeta()).getLore())));
        OriginAttributeAPI.INSTANCE.callUpdate(livingEntity);
    }

    @Override
    public void deleteAttribute(String source, LivingEntity livingEntity) {
        OriginAttributeAPI.INSTANCE.removeExtra(livingEntity.getUniqueId(), source);
        OriginAttributeAPI.INSTANCE.callUpdate(livingEntity);
    }

}
