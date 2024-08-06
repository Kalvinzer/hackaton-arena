rootProject.name = "hackathon-arena-back"

include("app")

include("infrastructure:persistence:postgres:configuration")
include("infrastructure:persistence:postgres:migration")
