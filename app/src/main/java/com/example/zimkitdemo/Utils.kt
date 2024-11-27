package com.example.zimkitdemo

import kotlin.random.Random


object Utils {
    fun randomName(): String {
        val names = arrayOf(
            "Aaliyah",
            "Abigail",
            "Addison",
            "Adrian",
            "Adriana",
            "Aiden",
            "Alanis",
            "Alexander",
            "Alexandra",
            "Alexis",
            "Allison",
            "Alondra",
            "Alyssa",
            "Amanda",
            "Amelia",
            "Andrea",
            "Andrew",
            "Angel",
            "Anna",
            "Anthony",
            "Aria",
            "Ariana",
            "Ashley",
            "Aspen",
            "Aubree",
            "Aubrey",
            "Aurora",
            "Austin",
            "Ava",
            "Avery",
            "Benjamin",
            "Bentley",
            "Brantley",
            "Braxton",
            "Brayden",
            "Brianna",
            "Bridger",
            "Brody",
            "Brooklyn",
            "Caleb",
            "Cameron",
            "Camila",
            "Carlos",
            "Caroline",
            "Carter",
            "Charles",
            "Charlotte",
            "Charlottte",
            "Chase",
            "Chloe",
            "Christian",
            "Christopher",
            "Claire",
            "Colton",
            "Connor",
            "Cooper",
            "Daniel",
            "David",
            "Diego",
            "Dylan",
            "Easton",
            "Eleanor",
            "Eli",
            "Elijah",
            "Elizabeth",
            "Ella",
            "Ellie",
            "Emily",
            "Emma",
            "Ethan",
            "Evan",
            "Evelyn",
            "Ezekiel",
            "Ezra",
            "Faith",
            "Gabriel",
            "Gabriela",
            "Gabriella",
            "Gavin",
            "Genesis",
            "Gianna",
            "Grace",
            "Grayson",
            "Hadley",
            "Hailey",
            "Hannah",
            "Harper",
            "Hazel",
            "Henry",
            "Hudson",
            "Hunter",
            "Ian",
            "Isaac",
            "Isabella",
            "Isaiah",
            "Jace",
            "Jack",
            "Jackson",
            "Jacob",
            "James",
            "Jaxon",
            "Jayden",
            "Jeremiah",
            "Jesus",
            "John",
            "Jose",
            "Joseph",
            "Joshua",
            "Josiah",
            "Juan",
            "Julia",
            "Julian",
            "Kamila",
            "Katherine",
            "Kayla",
            "Kaylee",
            "Kevin",
            "Khloe",
            "Kingston",
            "Landon",
            "Layla",
            "Leah",
            "Levi",
            "Liam",
            "Lillian",
            "Lily",
            "Lincoln",
            "Logan",
            "Lucas",
            "Lucy",
            "Luis",
            "Luke",
            "Lydia",
            "Madison",
            "Makayla",
            "Mary",
            "Mason",
            "Matthew",
            "Maya",
            "Mia",
            "Micah",
            "Michael",
            "Mila",
            "Naomi",
            "Natalie",
            "Nathan",
            "Nevaeh",
            "Nicholas",
            "Nicole",
            "Noah",
            "Nora",
            "Oakley",
            "Oliver",
            "Olivia",
            "Owen",
            "Paisley",
            "Paola",
            "Parker",
            "Piper",
            "Riley",
            "Robert",
            "Ruby",
            "Ryan",
            "Ryker",
            "Sadie",
            "Samantha",
            "Samuel",
            "Sarah",
            "Savannah",
            "Sawyer",
            "Scarlett",
            "Sebastian",
            "Serenity",
            "Skylar",
            "Sofia",
            "Sophia",
            "Taylor",
            "Theodore",
            "Tyler",
            "Valeria",
            "Victoria",
            "William",
            "Wyatt",
            "Ximena",
            "Yadiel",
            "Zoe",
            "Zoey"
        )
        val index = Random.nextInt(names.size)
        return names[index]
    }
}