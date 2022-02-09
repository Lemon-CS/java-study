package com.fangpeng.design.pattern.memento.white_box;

/**
 * 备忘录对象管理对象
 * @author 方鹏
 * @date 2022年02月09日 5:35 下午
 */
public class RoleStateCaretaker {

    //声明RoleStateMemento类型的变量
    private RoleStateMemento roleStateMemento;

    public RoleStateMemento getRoleStateMemento() {
        return roleStateMemento;
    }

    public void setRoleStateMemento(RoleStateMemento roleStateMemento) {
        this.roleStateMemento = roleStateMemento;
    }

}
