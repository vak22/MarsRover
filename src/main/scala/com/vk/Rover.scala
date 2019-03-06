package com.vk

object Rover extends App {


  case class Coordinates(
                          x: Int,
                          y: Int
                        )

  case class Direction(
                        facing: String,
                      )

  case class Position(
                       coordinates: Coordinates,
                       direction: Direction
                     )


  def grid(): Unit = ???


  def startingPosition(): Position = {

    val startingCoordinates = Coordinates(0, 0)
    val startingDirection = Direction("North")

    val startingPosition = Position(startingCoordinates, startingDirection)

    println(s"The Mars Rover is at the $startingCoordinates facing $startingDirection")

    startingPosition

  }


  def getInstructions(position: Position): Unit = {

    readLine("What way do you want to move?") match {

      case "forward" =>
        moveForward()

      //        val newPostion = Position(newCoordinates, Direction.facing)

      case "rotate clockwise" =>
        rotateClockwise()

      case "rotate anticlockwise" =>
        rotateAntiClockwise()

      case "stop" => println("Stopped")

      case _ => println("That is not a valid movement, please choose either forward, rotate clockwise, or rotate anticlockwise.")
        getInstructions(position)
    }

    position


    def moveForward(): Coordinates = {

      readLine("How many positions do you want to move?").toInt match {

        case num => {

          val newCoordinates = Coordinates(1, 0)

          val newDirection = Direction("North")

          println(s"The Mars Rover is at the $newCoordinates facing $newDirection")
          newCoordinates

        }

        case _ => println("That is not a valid movement, please enter a number.")
          moveForward()

      }

    }


    def rotateClockwise(): Direction = {

      val newDirection = new Direction("East")

      println(s"You are now facing $newDirection")

      getInstructions(position)

      newDirection
    }


    def rotateAntiClockwise(): Direction = {

      val newDirection = new Direction("West")

      println(s"You are now facing $newDirection")

      getInstructions(position)

      newDirection
    }

  }

  //getInstructions(Coordinates(0,0), Direction)

}
