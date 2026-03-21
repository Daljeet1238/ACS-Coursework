
/**
 * Testing our person class
 *
 * @author Daljeet Singh 3169763
 * @version 17th Nov, 2024
 */
public class Person {
    private String name;
    private Person father;
    private Person mother;

    public Person(String name, Person father, Person mother){
        this.name = name;
        this.father = father;
        this.mother = mother;
    }

    public Person(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Person getFather(){
        return this.father;
    }

    public void setFather(Person father){
        this.father = father;
    }

    public Person getMother(){
        return this.mother;
    }

    public void setMother(Person mother){
        this.mother = mother;
    }

    public void setParent(Person father, Person mother){
        this.father = father;
        this.mother = mother;
    }

    public boolean checkFamily(String name){
        if(this.name.equals(name)){
            return true;
        }else if(father != null && father.checkFamily(name)){
            return true;
        }else if(mother != null && mother.checkFamily(name)){
            return true;
        }
        return false;
    }
}
