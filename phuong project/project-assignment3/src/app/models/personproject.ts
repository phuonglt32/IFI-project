export class personproject {

  constructor(
    public id: {
      idPersonal: number,
      idProjectRole: number
    },
    public projectName: string,
    public endDate: Date,
    public startDate: Date
  ) { }

}
