package my.edu.umk.pams.academic.term.model;

/**
 * @author PAMS
 */
    public enum AdEnrollmentApplicationAction {

        ADD,
        DROP;

        public static AdEnrollmentApplicationAction get(int index) {
            return values()[index];
        }


    }
