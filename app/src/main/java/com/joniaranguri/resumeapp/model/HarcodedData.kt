package com.joniaranguri.resumeapp.model

// Work Detail Screen
val workDetail = WorkDetail(
    "MercadoLibre",
    "Ssr Software Engineer",
    "Aug 2021 - May 2022",
    "Lorem ipsum dolor sit amet,<br> <ul><li> - Coffee</li><li> - Tea</li><li> - Milk</li></ul>  Using <span style=\"color: #33E283\">Kotlin</span> <a href=\"mailto:someone@example.com\">Send email</a> consectetur adipiscing elit, <a href=\"https://www.w3schools.com\">Visit W3Schools</a> sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.<p>  Enter the competition by <span style=\"color: #ff0000\">January 30, 2011</span> and you could win up to \$\$\$\$ — including amazing  <span style=\"color: #FFFFFF\">summer</span>  trips!</p> Some last paragraph",
    "https://firebasestorage.googleapis.com/v0/b/joniaranguri-resume.appspot.com/o/joni-blue-dark.png?alt=media&token=d12dd194-5a1f-4b37-b828-208d2cd3e96c",
    listOf(
        Skill("Kotlin", "https://www.svgrepo.com/show/353980/kotlin.svg"),
        Skill("Java", "https://www.svgrepo.com/show/353980/kotlin.svg"),
        Skill("UML", "https://www.svgrepo.com/show/353980/kotlin.svg"),
        Skill("Leadership", "https://www.svgrepo.com/show/353980/kotlin.svg"),
        Skill("Kotlin", "https://www.svgrepo.com/show/353980/kotlin.svg"),
        Skill("Kotlin", "https://www.svgrepo.com/show/353980/kotlin.svg"),
        Skill("Kotlin", "https://www.svgrepo.com/show/353980/kotlin.svg"),
        Skill("Kotlin", "https://www.svgrepo.com/show/353980/kotlin.svg"),
        Skill("Kotlin", "https://www.svgrepo.com/show/353980/kotlin.svg"),
        Skill("Kotlin", "https://www.svgrepo.com/show/353980/kotlin.svg"),
        Skill("Kotlin", "https://www.svgrepo.com/show/353980/kotlin.svg"),
        Skill("Kotlin", "https://www.svgrepo.com/show/353980/kotlin.svg"),
        Skill("Kotlin", "https://www.svgrepo.com/show/353980/kotlin.svg"),
        Skill("Kotlin", "https://www.svgrepo.com/show/353980/kotlin.svg")
    )
)
data class SingleSection<C>(val description: String, val data: C) //todo:remove

// Contact Section
val contactSection = SingleSection<Contact>(
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
    Contact(
        "+54 911 5651 3731",
        "Yes you got it Joni, we want to interview you!",
        listOf(
            Social(
                "Linkedin",
                "https://www.svgrepo.com/show/452047/linkedin-1.svg",
                "https://www.linkedin.com/in/jonathan-aranguri/"
            ),
            Social(
                "Web",
                "https://www.svgrepo.com/show/438949/web-round.svg",
                "https://joniaranguri.com/"
            ),
            Social(
                "Github",
                "https://www.svgrepo.com/show/512317/github-142.svg",
                "https://github.com/joniaranguri"
            )
        )
    )
)