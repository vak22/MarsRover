package com.vk

final case class Rover(
    coordinates: Coordinates,
    direction: Direction
) {
  def moveForward: Rover = Rover.moveForward(this)

  def moveForwardBy(steps: Int): Rover = Rover.moveForwardBy(this, steps)
}

object Rover {

  def moveForward(r: Rover): Rover = {

    r.direction match {
      case Direction.North =>
        Rover(Coordinates.moveUp(r.coordinates), r.direction)

      case Direction.South =>
        Rover(Coordinates.moveDown(r.coordinates), r.direction)

      case Direction.East =>
        Rover(Coordinates.moveRight(r.coordinates), r.direction)

      case Direction.West =>
        Rover(Coordinates.moveLeft(r.coordinates), r.direction)

    }
    //stayOnGrid(r, r.coordinates)
  }

  def moveForwardBy(r: Rover, steps: Int): Rover = {

    r.direction match {
      case Direction.North =>
        Rover(Coordinates.moveUpBy(r.coordinates, steps), r.direction)

      case Direction.South =>
        Rover(Coordinates.moveDownBy(r.coordinates, steps), r.direction)

      case Direction.East =>
        Rover(Coordinates.moveRightBy(r.coordinates, steps), r.direction)

      case Direction.West =>
        Rover(Coordinates.moveLeftBy(r.coordinates, steps), r.direction)

    }

    if (steps == 0) {
      stayOnGrid(r, Coordinates.default)
    } else moveForwardBy(moveForward(r), steps - 1)
  }

  def stayOnGrid(r: Rover, size: Coordinates): Rover = {
    updateRoverCoords(r,
                      Coordinates(wrapValue(r.coordinates.x, size.x),
                                  wrapValue(r.coordinates.y, size.y)))
  }

  val updateRoverCoords: (Rover, Coordinates) => Rover = (r, c) =>
    Rover(c, r.direction)

  val wrapValue: (Int, Int) => Int = (value, limit) => value % limit

  // 1: Enter a list of HighLevel instructions
  // 2: Convert to a List[List[Instruction]]
  // 3: Flatten
  // 4: Execute

  //HighLevel.toInstructions(ForwardBy(3), Direction.starting)
}
