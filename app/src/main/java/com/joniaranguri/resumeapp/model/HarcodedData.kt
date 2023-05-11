package com.joniaranguri.resumeapp.model

// Work section
val workSection = Section<Work>(
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
    listOf(
        Work(
            "Retargetly",
            "Ssr Software Engineer",
            "June 2022 - Present",
            "https://firebasestorage.googleapis.com/v0/b/joniaranguri-resume.appspot.com/o/rely-bg.svg?alt=media&token=ea5e852d-d74e-4f4a-8726-8313989a848a"
        ), Work(
            "MercadoLibre",
            "Ssr Software Engineer",
            "Aug 2021 - May 2022",
            "https://cdn.worldvectorlogo.com/logos/mercadolibre.svg"
        ), Work(
            "MercadoLibre",
            "Software Engineer Analyst",
            "Jan 2020 - Jul 2021",
            "https://cdn.worldvectorlogo.com/logos/mercadolibre.svg"
        ), Work(
            "MercadoLibre",
            "Software Engineer Assistant",
            "Jun 2019 - Jan 2020",
            "https://cdn.worldvectorlogo.com/logos/mercadolibre.svg"
        ), Work(
            "SysOne",
            "Fullstack Web Developer",
            "Jan 2019 - Jun 2019",
            "https://firebasestorage.googleapis.com/v0/b/joniaranguri-resume.appspot.com/o/sysone-logo.svg?alt=media&token=867b6d38-1dad-4d0f-9357-89b374c909fa"
        ), Work(
            "Appstract",
            "Junior Android Developer",
            "Dec 2017 - Aug 2018",
            "https://firebasestorage.googleapis.com/v0/b/joniaranguri-resume.appspot.com/o/appstract-logo.svg?alt=media&token=e863fec1-3b42-42df-b878-44c4dc8ef6ad"
        )
    )
)

// Education Section
val educationSection = Section<Education>(
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
    listOf(
        Education(
            "Universidad Nacional de La Matanza \uD83C\uDDE6\uD83C\uDDF7",
            "https://www.unlam.edu.ar/",
            "Informatics Engineering",
            "Apr 2016 - Present",
            "https://iconape.com/wp-content/files/ka/193872/svg/193872.svg"
        )
    )
)

// Languages Section
val languagesSection = Section<Language>(
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
    listOf(
        Language(
            "English",
            "Advanced",
            "https://www.svgrepo.com/show/405645/flag-for-flag-united-states.svg",
            "greenLight"
        ), Language(
            "Spanish",
            "Native",
            "https://www.svgrepo.com/show/405610/flag-for-flag-spain.svg",
            "greenLight"
        ),
        Language(
            "French",
            "Beginner",
            "https://www.svgrepo.com/show/405485/flag-for-flag-france.svg",
            "greenLight"
        ),
        Language(
            "German",
            "Starting",
            "https://www.svgrepo.com/show/405490/flag-for-flag-germany.svg",
            "greenLight"
        )
    )
)

data class Section<C>(val description: String, val sectionList: List<C>) //todo :remove
data class SingleSection<C>(val description: String, val data: C) //todo:remove

// Projects Section
val projectsSection = Section<Project>(
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
    listOf(
        Project(
            "Pow(2,8)++;",
            "ICPC Competitive Programming Team",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "Working",
            "https://firebasestorage.googleapis.com/v0/b/joniaranguri-resume.appspot.com/o/icpc-logo.svg?alt=media&token=50021be7-0bb1-4b05-bf9b-e545f5c00e06",
            ""
        ),
        Project(
            "ThinkingCoder",
            "Youtube Channel",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "Starting",
            "https://firebasestorage.googleapis.com/v0/b/joniaranguri-resume.appspot.com/o/thinking-coder-bg.svg?alt=media&token=65c87db0-a610-460a-8dcd-39296c36c5a2",
            "https://www.youtube.com/@thinkingcoder"
        ),
        Project(
            "Elecciones Argentinas",
            "Mobile App + Blockchain network",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "Starting",
            "https://www.svgrepo.com/show/405411/flag-for-flag-argentina.svg",
            ""
        ),
        Project(
            "NearYou",
            "Freelance Flutter App",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "Done",
            "https://firebasestorage.googleapis.com/v0/b/joniaranguri-resume.appspot.com/o/nearyou.svg?alt=media&token=78c9ebc0-2351-4144-9d61-3b28dc8547f3",
            "https://github.com/joniaranguri/near_you"
        ),
        Project(
            "OnFuture",
            "Web page design & implementation",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "Done",
            "https://onfuture-39e9d.web.app/assets/images/logo.png",
            "https://onfuture-39e9d.web.app/"
        ),
        Project(
            "JoniAranguri's Blog",
            "Web page design & Implementation",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "Working",
            "https://firebasestorage.googleapis.com/v0/b/joniaranguri-resume.appspot.com/o/joniaranguri-logo.svg?alt=media&token=f7cd04ed-9b99-4afc-b624-fac8f563a890",
            "https://joniaranguri.com/"
        )
    )
)

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