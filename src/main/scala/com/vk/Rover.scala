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
  }

  def moveForwardBy(r: Rover, steps: Int): Rover = {

    if (steps == 0) {
      offGrid(r)
      r
    } else moveForwardBy(moveForward(r), steps - 1)

  }

  def offGrid(r: Rover): Rover = {

    val grid: Coordinates = Coordinates(10, 10)

    if (r.coordinates.y > grid.y && r.coordinates.x > grid.x)
      Rover(Coordinates(r.coordinates.x - grid.x, r.coordinates.y - grid.y),
            r.direction)
    else if (r.coordinates.y > grid.y)
      Rover(Coordinates(r.coordinates.x, r.coordinates.y - grid.y), r.direction)
    else
      Rover(Coordinates(r.coordinates.x - grid.x, r.coordinates.y), r.direction)

  }

  Instruction.getInstructions(Rover(Coordinates.zero, Direction.North),
                              Instruction.Forward)

}
