class Test {

    public static void main(String[] args) {
        new Programmer(1);
    }

    public static class TeamLead {
        private final int numTeamLead;

        public TeamLead(int numTeamLead) {
            this.numTeamLead = numTeamLead;
            employ();
        }

        private void employ() {
            System.out.println(numTeamLead + " teamlead");
        }

    }

    public static class Programmer extends TeamLead {
        private final int numProgrammer;

        public Programmer(int numProgrammer) {
            super(numProgrammer);
            this.numProgrammer = numProgrammer;
            employ();

        }

        private void employ() {
            System.out.println(numProgrammer + " programmer");
        }
    }
}
