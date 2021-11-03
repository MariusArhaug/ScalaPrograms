import javax.print.attribute.standard.MultipleDocumentHandling


object ObjectOrientation extends App {

    // Class declaration and instantiation
    class Person(val name: String)
    class Building {
        val stories = 0
        def clean() = println("house cleaned")
    }

    // We need to make the style-field visible outside of the class with val
    val me = new Person("Jesper")
    println(me.name)

    val abuilding = new Building
    abuilding.clean()

    // Inheritence
    class Skyscraper extends Building

    // Constructor is in the class declaration
    class House(val style: String) extends Building
    val uglyHouse = new House("nouveau")

    println(uglyHouse.style)



    // Other, more fancy things:

    // Sybtype polymorphism
    val someHouse: Building = new House("modern")
    someHouse.clean() // Will call Building's clean if House doesn't implement it too

    // Abstract class - not all method need implementations
    abstract class DestructableBuilding {
        val cost = 100000 // Default value
        def destroy(): Unit // No implementation
    }
    // fields and methods are public by default, restricable with "private" or "protected"

    // Interface is the most unimplemented class. It only restricts the possible implementation and types
    trait Housed { // lives in a house
        var home: House
    }

    // Why does none of this want to work??
    /*
    class Cleaner(name: String) extends Person {

    }

    
    class Cleaner(name: String, home: House) extends Person with Housed {
        def clean(building: Building): Unit = println("Building cleaned by cleaner") // How would i do ...by + self.name here??
    }
    */




    //ended at https://youtu.be/sby4rxdmabI?t=836


}