package com.kim.sshstudy.action;

import com.kim.sshstudy.service.RepairServiceI;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 伟阳 on 2016/1/28.
 */
@Action(value = "repairAction")
public class RepairAction extends BaseAction {

    private RepairServiceI repairService;

    @Autowired
    public void setRepairService(RepairServiceI repairService) {
        this.repairService = repairService;
    }

    public void init(){
        repairService.repair();
    }
}
