import * as csv from 'csv-parse';
import { Injectable } from '@nestjs/common';

@Injectable()
export class ImportService {
  async parseCsvBuffer(buffer: Buffer){
    return new Promise((resolve, reject)=>{
      const records: any[] = [];
      const parser = csv.parse({ columns: true, skip_empty_lines: true });
      parser.on('readable', function(){
        let record;
        // @ts-ignore
        while(record = parser.read()){
          records.push(record);
        }
      });
      parser.on('end', ()=>resolve(records));
      parser.on('error', err=>reject(err));
      parser.write(buffer);
      parser.end();
    });
  }
}
