package org.xiaoh.data.openapi.common.util;

import java.util.List;

public class ADTO extends AbstractObject
{
    private String name = "pengyucheng";
    
    private int age = 30;
    
    private List<String> interests;

    
    public ADTO()
    {
        super();
    }

    public ADTO(String name, int age, List<String> interests)
    {
        super();
        this.name = name;
        this.age = age;
        this.interests = interests;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public List<String> getInterests()
    {
        return interests;
    }

    public void setInterests(List<String> interests)
    {
        this.interests = interests;
    }

    @Override
    public String toString()
    {
        return "ADTO [name=" + name + ", age=" + age + ", interests=" + interests + "]";
    }
    
}
