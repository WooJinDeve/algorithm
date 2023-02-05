import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(String[][] book_time) {
        final List<Reservation> reservations = Arrays.stream(book_time)
                .map(time -> new Reservation(convertToTime(time[0]), convertToTime(time[1])))
                .sorted(Comparator.comparingInt(a -> a.start))
                .collect(Collectors.toList());

        List<Reservations> result = new LinkedList<>();

        for (Reservation reservation : reservations) {
            boolean ok = false;
            for (Reservations r : result) {
                if (r.hasNext(reservation)) {
                    r.addLast(reservation);
                    ok = true;
                    break;
                }
            }

            if (!ok){
                final Reservations temp = new Reservations(new LinkedList<>());
                temp.addLast(reservation);
                result.add(temp);
            }
        }

        return result.size();
    }

    private int convertToTime(final String time) {
        final String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }

    private class Reservations{
        List<Reservation> reservations;

        public Reservations(final List<Reservation> reservations) {
            this.reservations = reservations;
        }

        public boolean hasNext(Reservation obj) {
            final Reservation reservation = reservations.get(reservations.size() - 1);
            return reservation.finish <= obj.start && (reservation.finish + obj.finish - obj.start) < 1440;
        }

        public void addLast(Reservation obj){
            reservations.add(obj);
        }
    }

    private class Reservation{
        private final int start;
        private final int finish; // finish = end time + clean time

        public Reservation(final int start, final int finish) {
            this.start = start;
            this.finish = finish + 10;
        }
    }
}