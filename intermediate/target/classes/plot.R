library(ggplot2)
library(scales)

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

   plot <- ggplot(data = data.frame(temperature = forecast$values, time = dates),
                aes(time, temperature, group=1)) +
                geom_line(color="steelblue")
    print(plot)
    svg.off()
}
