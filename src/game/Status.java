package game;

/**
 * Use this enum class to give `buff` or `debuff`.
 * It is also useful to give a `state` to abilities or actions that can be attached-detached.
 */
public enum Status {
    HOSTILE_TO_ENEMY, // use this status to be considered hostile towards enemy (e.g., to be attacked by enemy)
    SHROOMPOWERED, // use this status to tell that current instance has "grown".
    STARPOWERED, // use this status to tell the current instance that mario has consumed a power star
    DORMANT, // use this status to tell that current instance of Koopa is dormant
    FIREPOWERED, // use this status to tell that player is equipped with fire attack
    FLYING, // use this status to tell the engine that the entity is flying
    RESETTABLEGROUND, // use this status to check whether ground is resettable
}
