export function periodOrderToDates(periodOrder: string): Date[] {
  switch (periodOrder) {
    case'FIRST':
      return [new Date(0, 0, 0, 6, 50, 0), new Date(0, 0, 0, 9, 15, 0)];
    case 'SECOND':
      return [new Date(0, 0, 0, 9, 25, 0), new Date(0, 0, 0, 11, 50, 0)];
    case 'THIRD':
      return [new Date(0, 0, 0, 12, 30, 0), new Date(0, 0, 0, 14, 55, 0)];
    case 'FOURTH':
      return [new Date(0, 0, 0, 15, 5, 0), new Date(0, 0, 0, 17, 30, 0)];
    case 'FIFTH':
      return [new Date(0, 0, 0, 17, 45, 0), new Date(0, 0, 0, 21, 0, 0)];
    default:
      return [];
  }
}

export function sequenceTypeToStrings(sequenceType: string): string[] {
  switch (sequenceType) {
    case 'EVEN_DAYS':
      return ['Monday', 'Wednesday', 'Friday'];
    case 'ODD_DAYS':
      return ['Tuesday', 'Thursday', 'Saturday'];
    default:
      return [];
  }
}

export function periodOrderToString(periodOrder: string): string {
  switch (periodOrder) {
    case 'FIRST':
      return '6:50 - 9:15';
    case 'SECOND':
      return '9:25 - 11:50';
    case 'THIRD':
      return '12:30 - 14:55';
    case 'FOURTH':
      return '15:05 - 17:30';
    case 'FIFTH':
      return '17:45 - 21:00';
    default:
      return 'INVALID PERIOD ORDER';
  }
}

export function getLevelOrder(level: string) {
  switch (level) {
    case 'BEGINNER':
      return 0;
    case 'BASIC':
      return 1;
    case 'INTERMEDIATE':
      return 2;
    case 'ADVANCED':
      return 3;
    default:
      return 0;
  }
};
