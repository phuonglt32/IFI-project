export class person {

    constructor(
      public id: number,
      public name :string,
      public phone: string,
      public dob: Date,
      public sex: string,
      private skill: string,
      private note: string
    ) { }

  }
