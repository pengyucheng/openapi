package org.xiaoh.data.openapi.common.util;

import java.util.ArrayList;
import java.util.List;

public class AVO extends AbstractObject
{
    private String name = "pengyucheng";
    
    private int age = 30;
    
    private List<String> interests;

    public AVO(String name, int age, List<String> interests)
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
        return "AVO [name=" + name + ", age=" + age + ", interests=" + interests + "]";
    }

    public static void main(String[] args) throws Exception
    {
        List<String> interests = new ArrayList<String>();
        interests.add("basketball");
        interests.add("pingpang");
        
        AVO avo = new AVO("pengyc",18,interests);
        
        ADTO adto = avo.clone(ADTO.class);
        
        System.out.println(adto);
    }
}
