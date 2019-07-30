library(lattice)

ms_to_date = function(ms, t0="1970-01-01", timezone) {
        sec = ms / 1000
        as.POSIXct(sec, origin=t0, tz=timezone)
}

function(forecast, timestamps) {
    svg()

    dates <- c()
    for (ms in timestamps$values) {
          dates <- c(dates, ms/1000)
    }
    class(dates) = c('POSIXt','POSIXct')

   plot <- xyplot( temperature ~ time, data = data.frame(temperature = forecast$values, time = dates)
   ,type="l",
      xlab="Date",
      ylab = "Temperature")
    print(plot)
    grDevices:::svg.off()
}
