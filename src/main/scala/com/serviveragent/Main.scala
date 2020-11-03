package com.serviveragent

import com.typesafe.scalalogging.LazyLogging
import javax.security.auth.login.LoginException

object Main extends App with LazyLogging {
  lazy val appModules = new AppModules {}

  try appModules.jda
  catch {
    case _: LoginException => {
      logger.error("the provided token is invalid.")
      sys.exit()
    }
    case _: IllegalArgumentException => {
      logger.error(
        "the provided token is empty or null. Or the provided intents/cache configuration is not possible.")
      sys.exit()
    }
  }

  logger.info("start hukuyaku-bot")
}
