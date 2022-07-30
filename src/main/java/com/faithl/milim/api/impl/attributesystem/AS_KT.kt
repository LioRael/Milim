package com.faithl.milim.api.impl.attributesystem

import com.faithl.milim.AttributeManager
import com.skillw.attsystem.api.AttrAPI.addAttribute
import com.skillw.attsystem.api.AttrAPI.getAttrData
import com.skillw.attsystem.api.AttrAPI.readItem
import com.skillw.attsystem.api.AttrAPI.removeAttribute
import com.skillw.attsystem.api.read.ReadGroup
import com.skillw.attsystem.api.status.NumberStatus
import org.bukkit.entity.LivingEntity
import org.bukkit.inventory.ItemStack

class AS_KT:AttributeManager() {
    override fun getData(livingEntity: LivingEntity): Any {
        return livingEntity.getAttrData()?.toAttributeData()!!
    }

    override fun setAttribute(source: String, livingEntity: LivingEntity, attribute: MutableList<String>) {
        livingEntity.removeAttribute(source)
        livingEntity.addAttribute(source,attribute,false)
    }

    override fun setAttribute(
        source: String,
        livingEntity: LivingEntity,
        attribute: HashMap<String, Array<Number>>
    ) {
        livingEntity.removeAttribute(source)
        livingEntity.getAttrData()?.forEach { _, attrData ->
            attrData.filter { (att,_)-> attribute.contains(att.key) && att.readPattern is ReadGroup
            }.forEach loop@ { (attr, value) ->
                val num = attribute[attr.key] ?:return@loop
                value as NumberStatus
                value["valueMin"] = num[0].toDouble()
                value["valueMax"] = num[1].toDouble()
            }
        }
    }

    override fun setAttribute(source: String, livingEntity: LivingEntity, attribute: String) {
        livingEntity.removeAttribute(source)
        livingEntity.addAttribute(source, listOf(attribute),false)
    }

    override fun setAttribute(source: String, livingEntity: LivingEntity, itemStack: ItemStack) {
        livingEntity.removeAttribute(source)
        itemStack.readItem(livingEntity, null)
    }

    override fun deleteAttribute(source: String, livingEntity: LivingEntity) {
        livingEntity.removeAttribute(source)
    }
}